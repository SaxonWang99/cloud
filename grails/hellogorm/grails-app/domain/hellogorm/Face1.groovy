package hellogorm

class Face1 {

    Nose1 nose

    static constraints = {
    }

}

/*

Bidirectional many-to-one relationship from Face to Nose:

class Face {
    Nose nose
}

class Nose {
    static belongsTo = [face:Face]
}

Saves and deletes will cascade from Face to the associated Nose.

Grails Console Example:

import hellogorm.*

new Face1(nose:new Nose1()).save()
new Nose1(face:new Face1()).save() // will cause an error

def f = Face1.get(1)
f.delete() // both Face and Nose deleted

*/