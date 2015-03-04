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
    def q = createQuote(quoteParts, authors)
    println q
}

def createQuote(List quoteParts, List authors) {
    def rand = new Random()
    def n = quoteParts.size()
    def m = authors.size()
    
    quoteParts[rand.nextInt(n)][0] + ' ' +
    quoteParts[rand.nextInt(n)][1] + ' ' +
    quoteParts[rand.nextInt(n)][2] + '. By ' +
    authors[rand.nextInt(m)]
}