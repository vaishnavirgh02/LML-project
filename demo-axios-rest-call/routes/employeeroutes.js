const { default: axios } = require('axios');
const express = require('express');
const Employee = require('../objects/employees');

let employessroutes = express.Router();

employessroutes.all("/add", (req, res, next)=>{
    if(req.method == 'GET'){
        return res.render('add-employee.ejs', {
            employee: new Employee(0, "", "")
        })
    }else if(req.method == 'POST'){
        // your axios request here 
        //let i = new Employee(null ,req.body.empName, req.body.empSalary);
        axios
            .post('http://localhost:8080/employee/add', {"empName": req.body.empName, "empSalary": req.body.empSalary})
            .then((response)=>{
                return res.render('find-employee.ejs', {
                    employees: response.data,
                    messages: [{
                        type: "info", 
                        message: "new employee created with id = " + response.data.empId
                    }]
                })
            })

    }

});
/*
employessroutes.get("/find-employee/:empId", (req, res, next)=>{
    empId = res.params.empId

    axios
        .get('http://localhost:8080/find/'+req.params.empId)
        .then((response)=>{
            console.log(response)
            return res.render('find-employee.ejs', {
                empId: response*/
employessroutes.get("/find", (req, res, next)=> {
    if(req.query.empId){
        //console.log(req.query.empId);
        axios
        .get('http://localhost:8080/employee/find/' + req.query.empId)
        .then((response)=>{
            return res.render('find-employee.ejs', {
                employees: response.data,
                messages: null
            })
        }) 
    }else{
    return res.render('find-employee.ejs', {
        employees: null,
        messages: null
    })
}})

employessroutes.get("/find/:empId", (req, res, next)=>{
    let empId = req.params.empId
    
    //console.log(req);

    axios
        .get('http://localhost:8080/employee/find/' + req.params.empId)
        .then((response)=>{
            //console.log(response)
            //console.log(response.data);
            return res.render('find-employee.ejs', {
                employees: response.data,
                messages: null
            })
        })
});




module.exports = employessroutes;