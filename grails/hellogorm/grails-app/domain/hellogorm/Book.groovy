package hellogorm

/* 

	Table/Column Mappings

	Class Book 				-> Table:  book
	Attribute title 		-> Column: title
	Attribute releaseDate	-> Column: release_date
	Attribute ISBN			-> Column: isbn

*/

class Book {

    String title
    Date releaseDate
    String ISBN

    static constraints = {
    }
}

