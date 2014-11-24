sources = gridworld/*.java 
sources+= gridworld/gui/*.java 
sources+= gridworld/com/*.java 
sources+= gridworld/actions/*.java 
sources+= gridworld/levels/*.java
sources+= gridworld/objects/*.java 
sources+= gridworld/objects/ai/*.java 
sources+= gridworld/updates/*.java

all: gridworld.jar

Test.class: gridworld.jar Test.java
	javac -cp gridworld.jar:. Test.java

test: Test.class
	java -cp gridworld.jar:. Test

gridworld.jar: gridworld/.gwconf gridworld/levels/data/* $(sources)
	mkdir -p bin
	javac -d bin $(sources)
	cp gridworld/.gwconf bin/gridworld/.gwconf
	cp -r gridworld/levels/data bin/gridworld/levels/
	jar cfe gridworld.jar gridworld.StartConsole \
	-C bin gridworld
	chmod +x gridworld.jar

clean:
	rm -f *.class
	rm -rf bin

clean_all: clean
	rm -f gridworld.jar
