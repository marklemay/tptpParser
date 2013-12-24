package org.xtext.example.mydsl.tests;

///org.xtext.example.mydsl.tests/src/org/xtext/example/mydsl/tests/CheckThemALL.java
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
//				System.out.println(path );
		Reader reader = new BufferedReader(new FileReader(path));
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

	public static void main(String[] args) throws IOException {
//		File directory = new File("C:\\tptp\\fof\\axioms\\");
		//		File directory = new File("C:\\tptp\\fof\\problems\\");
//		File directory = new File("C:\\tptp\\cnf\\problems\\");
//		File directory = new File("C:\\tptp\\cnf\\axioms\\");
//		File directory = new File("C:\\tptp\\thf\\axioms\\");
//		File directory = new File("C:\\tptp\\thf\\problems\\");
//		File directory = new File("C:\\tptp\\tff\\axioms\\");
		File directory = new File("C:\\tptp\\tff\\problems\\");
		
		for (File file : directory.listFiles()) {
			try {
				CheckThemALL cta = new CheckThemALL();
				cta.parse(file.getAbsolutePath());
			} catch (Exception e) {
				System.out.println("(" + file.getAbsolutePath() + ":" + e);
			}
		}
		// InternalMyDslLexer lex = new InternalMyDslLexer(new
		// ANTLRFileStream("C:\\tptp\\cnf\\TOP016-1.p"));
		// CommonTokenStream tokens = new CommonTokenStream(lex);
		//
		//
		// InternalMyDslParser parser = new InternalMyDslParser(tokens);
		//
		// // try {
		// parser.getSourceName();//.expr();
		// try {
		// IParseResult result = parser.parse();
		// result.getSyntaxErrors();
		// } catch (RecognitionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// parser.getNumberOfSyntaxErrors();
		// // } catch (RecognitionException e) {
		// // e.printStackTrace();
		// // }
	}
}
