all: PasswordCracker.class GradeDatabase.class

GradeDatabase.class: GradeDatabase.java
	javac GradeDatabase.java

CrackerUtils.class: CrackerUtils.java GradeDatabase.class
	javac CrackerUtils.java

PasswordCracker.class: PasswordCracker.java CrackerUtils.class
	javac PasswordCracker.java

db: GradeDatabase.class
	java GradeDatabase

test: PasswordCracker.class
	java PasswordCracker

clean:
	rm -f *.class
