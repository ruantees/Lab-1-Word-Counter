package com.example.wordcounter

class WordCounter {
    companion object {
        fun getCharCount(textInputString: String): Int {
            return textInputString.length
        }

        private fun charInArr(array: Array<Char>, toFind: Char): Boolean {
            var found = false

            for (element in array) {
                if (element == toFind) {
                    found = true
                    break
                }
            }
            return found
        }

        fun getWordCount(textInputString: String): Int {
            var wordCount = 0
            val wordSeparators = arrayOf(' ', ',', '.')
            var isScanning = false

            for (char in textInputString){
                if (charInArr(wordSeparators, char)){
                    isScanning = false
                }
                else if(!isScanning){
                    isScanning = true
                    wordCount += 1
                }
            }
            return wordCount
        }
    }
}