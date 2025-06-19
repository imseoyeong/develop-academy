class Person {
  late String? name;
  late int? age;

  Person({required this.name, this.age});
}

void main() {
  Person p1 = new Person(name: "seo");
  print(p1.name);
  print(p1.age);
}



// class Person {
//   late String? name;
//   late int? age;
//
//   Person({required this.name, this.age});
// }
//
// void main() {
//   Person p1 = new Person(name: "seo");
//   print(p1.name);
//   print(p1.age);
// }



// class Person {
//   late String? name;
//   late int? age;
//
//   Person({this.name, this.age}); // 축약형으로 가능
// }
//
// void main() {
//   Person p1 = new Person(name: "seo");
//   print(p1.name);
//   print(p1.age);
// }



// class Person {
//   late String? name; //?는 null이 들어갈 수 있다는 뜻. 아니면 앞에 late (이건 null 못 들어감)
//   late int? age;
//
//   Person({String? name, int? age}) {
//     this.name = name;
//     this.age = age;
//   }
// }
//
// void main() {
//   Person p1 = new Person(name: "seo");
//   print(p1.name);
//   print(p1.age);
// }



// class Person {
//   late String name;
//   late int age;
//
//   Person({String name="Im", int age=20}) {
//     this.name = name;
//     this.age = age;
//   }
// }
//
// void main() {
//   Person p1 = new Person(age:30, name: "seo");
//   print(p1.name);
//   print(p1.age);
// }
