tptpParser
==========

An xtext based parser for the tptp grammer (http://www.cs.miami.edu/~tptp).  (can be used to generate a java parser, and may lead to an awesome eclipse plugin)

this is built with xtext v2.4.3, and we welcome all patches and pull requests!

If you use this libray, we'd love to hear about it!

Using the Parser
==========
the eaisiest way is to add
		<dependency>
			<groupId>tptp</groupId>
			<artifactId>parser</artifactId>
			<version>0.0.6-SNAPSHOT</version>
		</dependency>
and
	<repositories>
		<repository>
			<id>tptpParser-mvn-repo</id>
			<url>https://raw.github.com/marklemay/tptpParser/mvn-repo/</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
	</repositories>
to your maven pom.xml (we use the poor mans repo method http://stackoverflow.com/questions/14013644/hosting-a-maven-repository-on-github?answertab=votes#tab-top)


you can also make your project directly dependent on the binary jar (https://raw.github.com/marklemay/tptpParser/mvn-repo/tptp/parser/0.0.6-SNAPSHOT/parser-0.0.6-20140121.033204-1.jar) or the source jar (https://raw.github.com/marklemay/tptpParser/mvn-repo/tptp/parser/0.0.6-SNAPSHOT/parser-0.0.6-20140121.033204-1.jar).  this is not recomended becuase you will need to download transitive dependencies.


Committing
==========

browsing the source
----------
there is only 1 source file: https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser/src/com/theoremsandstuff/tptp/Parser.xtext

checkout and build the project
----------
* open eclipse with xtext http://www.eclipse.org/Xtext/download.html
* window -> open perspective -> other -> Git Repository Exploring
* paste https://github.com/marklemay/tptpParser.git into the left panel
* the Clone Git Reposity window will open
* click finish
* open tptpParser
* right click on Working Directory
* select Import Exiting Project
* next
* you should see the 4 projects selected
* finish
* go back to the java perspective (ignore any errors)
* open com.theoremsandstuff.tptp.parser -> src -> com.theoremsandstuff.tptp
* right click on Parser.xtext -> run as -> Generate Xtext Artifact

see http://www.eclipse.org/Xtext/documentation.html for information about using the xtext framework

see TODOs below about what you can improve

running the tests
----------
* go to /org.xtext.example.mydsl.tests/src/org/xtext/example/mydsl/tests/CheckThemALL.java https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java
* change the files paths ("C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Axioms", "C:\\tptp\\Problems\\Problems", "C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Problems") to point to your local directories of Problems and Axioms http://www.cs.miami.edu/~tptp/TPTP/Distribution/TPTP-v6.0.0.tgz, and compitition problem files http://www.cs.miami.edu/~tptp/CASC/24/Problems.tgz
* run the main function

(TODO: see TODOs below about how this test could be improved)

before committing makesure you do not incure any regressions by running the tests against all axioms, all problems, and all of the prevous compitition pormlams



The design principles
----------
 * the primary goal is the generated java parser, the eclipse plugin (while realy cool) is secondary
 * minimal/restrictive AST, we will ignore issues that happen in the extended biased problems, keeping is simple and restrictive will make it easier to use in compitition programs
 * grammar should be restrictive, no need for multiple lanuages in the same file
 * validate against all sample problems, this should be compititiion ready software
 * keep the eventual java parser and the eventual eclipse plugin (and the target tptp problem set in sync with version numbers)

global TODOs
----------
- houscleaning
 - [ ] currently unsuported files section
  - [ ] unsuported problems list from https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java
  - [ ] untested problems list from https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java
 - [ ] link the links in readme
 - [ ] clarify design principals
 - [ ] delete tmp
 - [ ] check spelling
 - [ ] reactivate theoremsandstuff.com
 - [ ] ...capitalization?
 - [ ] see what other ignored thingsdo'nt need to be checked in
- tests
 - [ ] make tests more paramiterized
 - [ ] make tests paramiterized junit tests
 - [ ] set up continous integration
- other stuff
- [x] what is the best way to do this? http://stackoverflow.com/questions/20253044/string-constants-causeing-unexpected-type-collisions-in-xtext/20280540?noredirect=1#20280540
- [x] merge the seperate implimentations, make things handld more consistently
- [ ] review the modles for name clarity (and spelling)
- [ ] review prolog number, variable, and constant syntax
- [ ] seperate antlr parser directory (may just be a copy and past procedure)
 - [ ] write download instructions in the readme
 - [ ] create a simple demo project that imports it?
- [x] eclipse download site (marklemay.github.io/tptpParser/site.p2)
 - [ ] write download instructions in the readme
 - [ ] add a picture!
- [ ] deploy to maven
- [ ] Continous integration setup
- [ ] seperate sublangues into seperate files
- [ ] autoformater
- [ ] tooltip hints
- [ ] file linking with the include directive (include from only the same language)
- [ ] eclipse icon?
- [ ] compiletime validation of linking and type checking
- [ ] comment meta info tagging
- [ ] seperate eclipse plugins that could just target the sublanguages? most users don't need all 
- [ ] syncronize and embed version number in the build properties, maven and documentation
- [ ] why doesn't this work https://github.com/blog/1375-task-lists-in-gfm-issues-pulls-comments
- [ ] write shameless self premotion about the project leaders.
- [ ] rename "parser" is an awful name

currently unsuported
TODO
