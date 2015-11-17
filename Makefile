JC = javac
JFLAGS = -g -Xlint:unchecked

sources = $(wildcard Utils/*.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	$(RM) Utils/*.class

%.class : %.java
	$(JC) $(JFLAGS) $<
