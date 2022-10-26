import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { PeopleModel } from './people.model';


@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {

  formValue !: FormGroup;
  peopleModelObj : PeopleModel = new PeopleModel();
  peopleData !: any;
  showCreate !: boolean;
  showUpdate !: boolean;


  constructor(private formbuilder: FormBuilder, private api : ApiService) { }
   

  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      name : [''],
      number : ['']
    })
    this.getPeopleDetails();
  }


  clickAddContact(){
    this.formValue.reset();
    this.showCreate = true;
    this.showUpdate = false;
  }
  
  postPeopleDetails(){
    this.peopleModelObj.name = this.formValue.value.name;
    this.peopleModelObj.number = this.formValue.value.number;
    
    this.api.postContact(this.peopleModelObj)
    .subscribe(res => {
      console.log(res);
      alert("contact added successfully");
      let ref = document.getElementById("cancel");
      ref?.click();
      this.formValue.reset();
      this.getPeopleDetails();
    },
    err => {
      alert("Something went wrong. ");
    })
    
  }

  getPeopleDetails(){
    this.api.getContact()
    .subscribe(res =>{
      this.peopleData = res;
    })
  }

  deletePeople(row : any){
    this.api.deleteContact(row.id)
    .subscribe(res=>{
      alert("Contact Deleted");
      this.getPeopleDetails();
    })
  }

  onEdit(row : any){
    this.showCreate = false;
    this.showUpdate = true;
    this.peopleModelObj.id = row.id;
    this.formValue.controls['name'].setValue(row.name);
    this.formValue.controls['number'].setValue(row.number);
  }

  
  updatePeopleDetails(){
    this.peopleModelObj.name = this.formValue.value.name;
    this.peopleModelObj.number = this.formValue.value.number;
    
    this.api.updateContact(this.peopleModelObj, this.peopleModelObj.id)
    .subscribe(res=>{
      alert("Updated Successfully");
      let ref = document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
      this.getPeopleDetails();
    })
    
  }


}
