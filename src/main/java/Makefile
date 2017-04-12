HADOOP = ${HADOOP_HOME}/bin/hadoop

APP = MaxTemperature
SRC = *.java
OUT = out

$(APP): $(SRC)
	# Create output directory for .class files
	mkdir -p $(OUT)
	# Compile .java files into bytecode (Java class files)
	javac -classpath `$(HADOOP) classpath` -d $(OUT) $(SRC)
	# Create the Java archive
	jar -cvf $(APP).jar -C $(OUT) .

clean:
	rm -rf $(OUT) *.jar
