# Sorting Algorithm Visualizer Application

A program that helps the user visualize the time complexity differences between multiple different sorting algorithms.

## Instructions to run program

Run only on CMD not Powershell

Command to rebuild project due to dependency changes: `mvn clean install`   // `mvn clean compile` will NOT work

Command to run: `java -cp target\sorting-algorithms-visualizer-1.0-SNAPSHOT.jar;lib\processingcore.jar main.Main`

## Instructions to interact with program:

Press 'R' to randomize
Press spacebar to sort
Use the left and right arrow keys to cycle between different algorithms
Use the up and down arrow keys to increase or decrease the fps by 5 frames from a range of 5-60