all: gridworld.jar

Test.class: gridworld.jar Test.java
	javac -cp gridworld.jar:. Test.java

test: Test.class
	java -cp gridworld.jar:. Test

gridworld.jar: gridworld/.gwconf gridworld/*.java gridworld/gui/*.java gridworld/com/*.java gridworld/actions/*.java gridworld/levels/*.java gridworld/objects/*.java gridworld/updates/*.java
	javac gridworld/*.java \
	gridworld/gui/*.java \
	gridworld/com/*.java \
	gridworld/actions/*.java \
	gridworld/levels/*.java \
	gridworld/objects/*.java \
	gridworld/updates/*.java
	jar cvfe gridworld.jar gridworld.StartConsole \
	gridworld/*.class \
	gridworld/gui/*.class \
	gridworld/com/*.class \
	gridworld/actions/*.class \
	gridworld/levels/*.class \
	gridworld/objects/*.class \
	gridworld/updates/*.class \
	gridworld/.gwconf
	chmod +x gridworld.jar

clean:
	rm -f *.class
	rm -f gridworld/*.class
	rm -f gridworld/gui/*.class
	rm -f gridworld/com/*.class
	rm -f gridworld/actions/*.class
	rm -f gridworld/levels/*.class
	rm -f gridworld/objects/*.class
	rm -f gridworld/updates/*.class

clean_all: clean
	rm -f gridworld.jar
