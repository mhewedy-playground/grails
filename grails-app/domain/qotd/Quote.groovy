package qotd

class Quote {
	
	String content
	String author
	Date created = new Date()

    static constraints = {
		author(nullable: false)
		content(nullable: false, maxSize: 1000)
		created(min: new Date())
    }
}
