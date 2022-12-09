### Andrew Lechner's Game of Life submission for Riot Games

This repository contains Andrew Lechner's submission for the Riot Games
"Game of Life" technical assignment

This project handles 64-bit numbers for the grid

## Building

Ensure tests pass with:
./gradlew test

Now build the jar with:
./gradlew build

The jar will be in app/build/libs/app.jar

## Executing

java -jar app/build/libs/app.jar < filename.in

Two input files are provided in /samplefiles

Input files should be of format:

(0, 0)  
(0, -1)  
(0, 1)  
(-9223372036854775808, -9223372036854775808)  

Output will be in Life 1.06 format:

#Life 1.06  
0 -1  
0 0  
0 1