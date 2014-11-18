all: gridworld_recompile

gridworld_recompile:
	javac gridworld/*.java

Test.class: gridworld_recompile
	javac Test.java

test: Test.class
	java Test

clean:
	rm -f *.class
	rm -f gridworld/*.class
