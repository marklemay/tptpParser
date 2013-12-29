package org.xtext.example.mydsl.tests;


////com.theoremsandstuff.tptp.parser.tests/src/org/xtext/example/mydsl/tests/CheckThemALL.java
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseException;
import org.xtext.example.mydsl.MyDslRuntimeModule;
import org.xtext.example.mydsl.MyDslStandaloneSetup;
import org.xtext.example.mydsl.parser.antlr.internal.InternalMyDslLexer;
import org.xtext.example.mydsl.parser.antlr.internal.InternalMyDslParser;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CheckThemALL {

	@Inject
	private IParser parser;

	Injector injector = Guice.createInjector(new MyDslRuntimeModule());

	public CheckThemALL() {
		setupParser();
	}

	private void setupParser() {
		Injector injector = new MyDslStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * Parses data provided by an input reader using Xtext and returns the root
	 * node of the resulting object tree.
	 * 
	 * @param reader
	 *            Input reader
	 * @return root object node
	 * @throws IOException
	 *             when errors occur during the parsing process
	 */
	public EObject parse(String path) throws IOException {
		// System.out.println(path );
		File file = new File(path);
		if (!readable(file)) {
			return null;
		}
		if (file.length() > 70000000) {
			System.out.println("(" + path + ") is too big " + file.length());
			return null;
		}

		Reader reader = new BufferedReader(new FileReader(file));

		IParseResult result = parser.parse(reader);

		if (result.hasSyntaxErrors()) {
			for (INode e : result.getSyntaxErrors()) {
				System.out.println("(" + path + ":" + e.getStartLine() + "): "
						+ e.getText());
			}
			// throw new
			// ParseException("Provided input contains syntax errors.");
		}
		return result.getRootASTElement();
	}

	public static boolean readable(File f) {

		switch (f.getName()) {
		// ignoreing advanced syntax quirks that are never used
		case "SYN000+2.p":
		case "SYN000-2.p":
		case "SYN000=2.p":
		case "SYN000^2.p":
		case "SYN000_2.p":

			// using the symbol "&" as a constant within an atom, wich is just
			// absurd
		case "SYO025^1.p":
			// '~' as a constant within an atom
		case "SYO042^1.p":
		case "SYO042^2.p":
		case "SYO544^1.p":
		case "SYO545^1.p":
		case "SYO546^1.p":

			// use of the pedefined '$distinct' construct.
		case "SYO561_1.p":
			// use of the pedefined '$ite_f' construct.
		case "SYO562_1.p":

			// use of fractions in fof
		case "SYO563+2.p":

			return false;
		default:
			return true;
		}
	}

	public static void ceckDir(File directory) {
		for (File file : directory.listFiles()) {
			try {
				if (file.isDirectory()) {
					ceckDir(file);
				} else {
					CheckThemALL cta = new CheckThemALL();
					cta.parse(file.getAbsolutePath());
				}
			} catch (Exception e) {
				System.out.println("(" + file.getAbsolutePath() + ":" + e);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File directory = new File("C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Axioms");
		ceckDir(directory);
		// compitition problems from last year (without solutions and batch
		// files)
		directory = new File("C:\\tptp\\Problems\\Problems");
		ceckDir(directory);
		directory = new File("C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Problems");
		ceckDir(directory);
	}
}
