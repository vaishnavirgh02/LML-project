class Employee{
    constructor(empId, empName, empSalary){
        this.empId=empId;
        this.empName=empName;
        this.empSalary=empSalary;
    }
}

//export default employees; // for es6 syntax
module.exports = Employee;