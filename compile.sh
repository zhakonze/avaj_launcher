find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt -d .
java simulator.Simulator src/scenario.txt