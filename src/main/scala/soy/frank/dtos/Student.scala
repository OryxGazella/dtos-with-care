package soy.frank.dtos

case class Student(firstName: String, lastName: String)

object Student {
  def create(firstName: String, lastName: String): Student = {
    if (firstName == null) return invalidStudent
    Student(firstName, lastName)
  }

  val invalidStudent = new Student("Invalid", "Invalid")
}