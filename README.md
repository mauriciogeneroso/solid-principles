<p align="center">
    <img height=85 src="images/solid-image.png">
    <br>This repository contains examples for SOLID principles
</p>

---
# What is SOLID?

SOLID is an acronym for 5 important design principles when using Object oriented Programming (OOP). The SOLID principles were first introduced by the famous Computer Scientist Robert J. Martin (or Uncle Bob) in his [paper](https://fi.ort.edu.uy/innovaportal/file/2032/1/design_principles.pdf) in 2000. But the SOLID acronym was introduced later by Michael Feathers.

SOLID are five patterns to encourage us to create more maintainable, understandable, and flexible software. Consequently, as our applications grow in size, we can reduce their complexity.

Each letter from SOLID has a meaning:

<strong>S</strong> - Single-responsibility Principle </br>
<strong>O</strong> - Open-closed Principle </br>
<strong>L</strong> - Liskov Substitution Principle </br>
<strong>I</strong> - Interface Segregation Principle </br>
<strong>D</strong> - Dependency Inversion Principle </br>

Below is describe each of them. 

---
## 1. SRP: Single-responsibility Principle

This principle means:
```
A class should have one and only one reason to change, meaning that a class should have only one job.
```

This principle provides the benefits:

* **Testing** – A class with one responsibility will have far fewer test cases.
* **Lower coupling** – Less functionality in a single class will have fewer dependencies.
* **Organization** – Smaller, well-organized classes are easier to search than monolithic ones.

#### Example:

Imagine the diagram and the class bellow and try to identify the problems:

<p align="center">
    <img src="diagrams/srp-before.png" />
</p>

```java
class Order {

    public BigDecimal calculateTotalSum() { /* code */; }
    public List<Item> getItems() { /* code */; }
    public long getItemsCount() { /* code */; }
    public boolean addItem(Item item) { /* code */; }
    public boolean deleteItem(Item item) { /* code */; }

    public void printOrder() { /* code */; }
    public void showOrder() { /* code */; }

    public void load() { /* code */; }
    public void save() { /* code */; }
    public void update() { /* code */; }
    public void delete() { /* code */; }
}

```

In this example, the class has 3 different responsibilities: store the order information, print data and manage the data/persist.

The example viole single-responsibility and causes some problems:
* **Low cohesion**: a class shouldn't have responsibility that is not its own.
* **High couple**: more responsibility, cause a lot of dependencies, making the program difficult to change.
* **Testing**: Difficult for testing.

Applying the SRP, we'll have this solution:

<p align="center">
    <img src="diagrams/srp-after.png" />
</p>

```java
class Order {

    public BigDecimal calculateTotalSum() { /* code */; }
    public List<Item> getItems() { /* code */; }
    public long getItemsCount() { /* code */; }
    public void addItem(Item item) { /* code */; }
    public boolean deleteItem(Item item) { /* code */; }
}

class OrderRepository {
    
    public Order load(UUID id) { /* code */; }
    public boolean save(Order order) { /* code */; }
    public boolean update(Order order) { /* code */; }
    public boolean delete(Order order) { /* code */; }
}

class OrderViewer {
    public void printOrder(Order order) { /* code */; }
    public void showOrder(Order order) { /* code */; }
}
```

Now we have 3 different classes to do each responsibility. This principle should be applied as well for methods,
it means each method should have one responsibility.

The SRP isn't applied only for classes, it can be applied for methods too. A method should not to do a lot of things, 
its name should be clean and the method code should do only one thing, following the principle <strong>Single Responsibility</strong>.  

---
## 2. Open-closed Principle

This principle says:

```
Classes should be open for extension, but closed for modification
```

What this principle means with **closed for modification** is, once the code is done, it should not be changed in the future.
And what this principle means with **open for extension** is, once the code is done, now we don't need to change it to add new functionalities, we just need to add the new functionality extending the existing functionalities.

The benefits:
* When we add new functionalities, it doesn't impact the existing code and we don't need to change the existing code.
* It will improve the code design.
* It avoids including bugs in the existing code.

#### Example:

Imagine we have a payment system with different type of employees. Each employment type has its own method to return the salary.

So, in this example bellow, we have a FullTime employment type and a Contractor, and a class to calculate the payslip that requires the salary. What is the problem with this code?

```java
class FullTimeContract {
    public BigDecimal salary() {
        return null;
    }
}

class Contractor {

    public BigDecimal payment() {
        return BigDecimal.ZERO;
    }
}

class Payslip {
    
    private BigDecimal balance;
    
    void calculate(Object employee) {
        if (employee instanceof FullTimeContract) {
            balance = ((FullTimeContract) employee).salary();
        } else if (employee instanceof Contractor) {
            balance = ((Contractor) employee).payment();
        } else {
            throw new IllegalArgumentException("Invalid employee type: "
                    + employee.getClass().getName());
        }
    }
}
```

The problem in this class is that, if the system needs to be modified to accept another type of employment/contrat, we need to change the existing code in `Payslip` class to support the new type.
In a `closed principle` we cannot change the existing code.

A class should be closed for modifications, and Uncle Bob teaches us how to fix it:
`Separate extensible behavior behind an interface, and flip the dependencies.`

Let`s refactoring the code and see how it looks:

```java
interface Employee {

    BigDecimal getSalary();
}

class FullTimeEmployee implements Employee {

    @Override
    public BigDecimal getSalary() {
        return null;
    }
}

class ContractorEmployee implements Employee {
    
    @Override
    public BigDecimal getSalary() {
        return null;
    }
}

class Payslip {

    private BigDecimal balance;

    public void calculate(Employee employee) {
        this.balance = employee.getSalary();
    }
}
```

In the new version of the code, we have an interface `Employee`, and the payslip manage an implementation of Employee, it gives us the flexibility to implement how much types of employee we want and we don't need to change the existing Payslip anymore.

`Now our class is closed for modifications, and open for extensions.`

#### Extra:
Open-Closed Principle is the base of the [Strategy](https://pt.wikipedia.org/wiki/Strategy) Design Pattern.

---
###Sources:

* https://www.baeldung.com/solid-principles
* https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898
* https://medium.com/desenvolvendo-com-paixao/o-que-%C3%A9-solid-o-guia-completo-para-voc%C3%AA-entender-os-5-princ%C3%ADpios-da-poo-2b937b3fc530