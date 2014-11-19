java_cp = json.jar:.
javac_flags = -cp $(java_cp)
java_flags = -cp $(java_cp)

all: gridworld_recompile

json.jar:
	wget http://central.maven.org/maven2/org/json/json/20090211/json-20090211.jar -O json.jar

gridworld_recompile: gridworld/*.java gridworld/gui/*.java json.jar
	javac $(javac_flags) gridworld/*.java
	javac $(javac_flags) gridworld/gui/*.java
	javac $(javac_flags) gridworld/com/*.java

Test.class: gridworld_recompile Test.java
	javac $(javac_flags) Test.java

test: Test.class
	java $(java_flags) Test

clean:
	rm -f *.class
	rm -f gridworld/*.class
	rm -f gridworld/gui/*.class
	rm -f gridworld/com/*.class
	rm -f test.png

clean_full: clean
	rm -f json.jar
