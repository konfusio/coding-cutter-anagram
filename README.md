## about

This project contains a sample implementation about searching for anagrams inside of a text file. The text file is predefined and
located in classpath of the apptlication. The search result is printed to console.

## Prerequisites

- compatible with java 8 to 17
- gradle

## build and run

- `gradlew build`
- `java -jar build/libs/anagramSampleApplication.jar`

## run in IDE

- execute `de.konfusio.anagram.AnagramSampleApplication`

## implementation details / limitations

Processing takes place entirely in memory. If processing of bigger text files is required, make sure that enough memory is
available. The required memory is more than twice the size of the text file plus the memory needed for app itself.

## needed changes for processing huge files

see https://github.com/konfusio/coding-cutter-anagram/issues/4
