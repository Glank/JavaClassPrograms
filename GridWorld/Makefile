java_cp = .
javac_flags = -cp $(java_cp)
java_flags = -cp $(java_cp)

all: gridworld_recompile

gridworld_recompile: gridworld/*.java gridworld/gui/*.java
	javac $(javac_flags) gridworld/*.java
	javac $(javac_flags) gridworld/gui/*.java
	javac $(javac_flags) gridworld/com/*.java
	javac $(javac_flags) gridworld/actions/*.java

Test.class: gridworld_recompile Test.java
	javac $(javac_flags) Test.java

test: Test.class
	java $(java_flags) Test

clean:
	rm -f *.class
	rm -f gridworld/*.class
	rm -f gridworld/gui/*.class
	rm -f gridworld/com/*.class
