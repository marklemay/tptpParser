tptpParser
==========
![usage screenshot](https://github.com/marklemay/tptpParser/blob/master/doc/demo.png?raw=true)

An xtext based parser for the [TPTP grammar](http://www.cs.miami.edu/~tptp).  (can be used as a java parser, or an awesome eclipse plugin)

This is built with xtext v2.4.3, and we welcome all patches and pull requests!

If you use this libray, we'd love to hear about it!

Installing the Eclipse Plugin
==========
We have tested against Eclipse Kepler

In Eclipse
* help -> install new software
* in the in the workwith field enter our update site "http://marklemay.github.io/tptpParser/site.p2"
* check parser
* click next
* follow the prompts until the plugin is installed

Using the Parser
==========
If you are using Maven, the easiest way to use this project is to add
```xml
<dependency>
	<groupId>tptp</groupId>
	<artifactId>parser</artifactId>
	<version>0.0.6-SNAPSHOT</version>
</dependency>
```
and
```xml
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
```
to your pom.xml (we use the [poor man's repo method](http://stackoverflow.com/questions/14013644/hosting-a-maven-repository-on-github?answertab=votes#tab-top))


You can also make your project directly dependent on the [binary jar](https://raw.github.com/marklemay/tptpParser/mvn-repo/tptp/parser/0.0.6-SNAPSHOT/parser-0.0.6-20140121.033204-1.jar) or the [source jar](https://raw.github.com/marklemay/tptpParser/mvn-repo/tptp/parser/0.0.6-SNAPSHOT/parser-0.0.6-20140121.033204-1.jar).  This is not recommended because you will need to download transitive dependencies.

See the test file [CheckThemALL.java](https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java) for usage 


Committing
==========

Browsing the source
----------
There is only 1 source file, [Parser.xtext](https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser/src/com/theoremsandstuff/tptp/Parser.xtext)

Checkout and build the project
----------
* Open [eclipse with xtext](http://www.eclipse.org/Xtext/download.html)
* window -> open perspective -> other -> Git Repository Exploring
* paste https://github.com/marklemay/tptpParser.git into the left panel
* the Clone Git Reposity window will open
* click finish
* open tptpParser
* right click on Working Directory
* select Import Exiting Project
* click next
* you should see the 4 projects selected
* click finish
* go back to the java perspective (ignore any errors)
* open com.theoremsandstuff.tptp.parser -> src -> com.theoremsandstuff.tptp
* right click on Parser.xtext -> run as -> Generate Xtext Artifact

For further reading about the xtext framework, look at the [offical Xtext documentation](http://www.eclipse.org/Xtext/documentation.html) or [Implementing Domain-Specific Languages with Xtext and Xtend](http://www.safariflow.com/library/view/Implementing-Domain-Specific-Languages-with-Xtext-and-Xtend/9781782160304/) by Lorenzo Bettini

See TODOs below about what you can improve

Running the tests
----------
* go to [/org.xtext.example.mydsl.tests/src/org/xtext/example/mydsl/tests/CheckThemALL.java](https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java)
* change the files paths ("C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Axioms", "C:\\tptp\\Problems\\Problems", "C:\\tptp\\TPTP-v6.0.0\\TPTP-v6.0.0\\Problems") to point to your local directories of [Problems and Axioms](http://www.cs.miami.edu/~tptp/TPTP/Distribution/TPTP-v6.0.0.tgz), and [compitition problem files](http://www.cs.miami.edu/~tptp/CASC/24/Problems.tgz)
* run the main function

(TODO: see TODOs below about how this test could be improved)

Before committing, run the tests against all axioms, all problems, and all of the prevous competition pormlams.



The design principles
----------
 * the primary goal is the generated java parser, the eclipse plugin (while really cool) is secondary
 * minimal/restrictive AST, we will ignore issues that happen in the extended biased problems, keeping the AST simple and restrictive will make it easier to use in competition programs
 * grammar should be restrictive, no need for multiple languages in the same file
 * validate against all sample problems, this should be competition-ready software
 * keep the eventual java parser and the eventual eclipse plugin (and the target tptp problem set in sync with version numbers)

global TODOs
----------
- houscleaning
 - [ ] currently unsupported files section
  - [ ] unsupported problems list from https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java
  - [ ] untested problems list from https://github.com/marklemay/tptpParser/blob/master/com.theoremsandstuff.tptp.parser.tests/src/com/theoremsandstuff/tptp/parser/tests/CheckThemALL.java
 - [x] link the links in readme
 - [ ] clarify design principles
 - [ ] delete tmp
 - [ ] check spelling
 - [ ] reactivate theoremsandstuff.com
 - [ ] ...capitalization?
 - [ ] see what other ignored things don't need to be checked in
- tests
 - [ ] make tests more parameterized
 - [ ] make tests parameterized junit tests
 - [ ] set up continous integration
- other stuff
- [x] what is the best way to aviod [type colisions](http://stackoverflow.com/questions/20253044/string-constants-causeing-unexpected-type-collisions-in-xtext/20280540?noredirect=1#20280540)? 
- [x] merge the separate implementations, make things handled more consistently
- [ ] review the models for name clarity (and spelling)
- [ ] review prolog number, variable, and constant syntax
- [ ] separate antlr parser directory (may just be a copy and past procedure)
 - [ ] write download instructions in the readme
 - [ ] create a simple demo project that imports it?
- [x] eclipse download site (marklemay.github.io/tptpParser/site.p2)
 - [ ] write download instructions in the readme
 - [ ] add a picture!
- [ ] deploy to maven
- [ ] Continuous integration setup
- [ ] separate sublanguages into separate files
- [ ] autoformatter
- [ ] tooltip hints
- [ ] file linking with the include directive (include from only the same language)
- [ ] eclipse icon?
- [ ] compiletime validation of linking and type checking
- [ ] comment meta info tagging
- [ ] separate eclipse plugins that could just target the sublanguages? most users don't need all 
- [ ] synchronize and embed version number in the build properties, maven and documentation
- [ ] why doesn't this work https://github.com/blog/1375-task-lists-in-gfm-issues-pulls-comments
- [ ] write shameless self promotion about the project leaders.
- [ ] rename "parser" is an awful name

currently unsupported
TODO
