def authors = [
   "Peter Ledbrook",
    "Glen Smith"
]

def quoteParts = [
    ["Time", "waits", "for no man"],
    ["The roundhouse kick", "solves", "all problems"],
    ["Groovy", "is", "the bees knees"]
]

for (i in 0..<10){
	def quote = createQuote(quoteParts, authors)
	println quote

	def bigLatinArr = []
	for (word in quote.split (/\s+/)) {
		bigLatinArr << bigLatinize(word)
	}
	println bigLatinArr.join(' ')
}


def createQuote(List quoteParts, List authors) {
	def rand = new Random()
	def n = quoteParts.size()
	def m = authors.size()

	quoteParts[rand.nextInt(n)][0] + ' ' +
			quoteParts[rand.nextInt(n)][1] + ' ' +
			quoteParts[rand.nextInt(n)][2] + ' by ' +
			authors[rand.nextInt(m)]
}

def bigLatinize(String word) {
	if (isVowel(word[0])) {
		word + 'awy'
	}else {
		def pos = firstVowelIdx(word)
		word[pos..-1] + word[0..pos] + 'ly'
	}
}

def isVowel(String ch) {
	ch in ['a', 'i', 'e', 'o', 'u']
}

def firstVowelIdx(String word) {
	for (i in 0..<word.length()) {
		if (isVowel(word[i])) {
			return i
		}
	}
	return -1
}

