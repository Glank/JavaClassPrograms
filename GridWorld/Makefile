all: gridworld_recompile

gridworld_recompile: gridworld/*.java
	javac gridworld/*.java

Test.class: gridworld_recompile Test.java
	javac Test.java

test: Test.class
	java Test

clean:
	rm -f *.class
	rm -f gridworld/*.class
	rm -f test.png
