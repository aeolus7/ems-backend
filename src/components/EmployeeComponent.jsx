import React, { useEffect, useState } from 'react';
import { createEmployee, getEmployee, updateEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {
  const [firstname, setFirstName] = useState('');
  const [lastname, setLastName] = useState('');
  const [email, setEmail] = useState('');

  const { id } = useParams();

  const [formError, setFormError] = useState(null);

  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      getEmployee(id)
        .then((response) => {
          setFirstName(response.data.firstname);
          setLastName(response.data.lastname);
          setEmail(response.data.email);
        })
        .catch((error) => console.error(error));
    }
  }, [id]);


  function handleFirstName(e) {
    setFirstName(e.target.value);
  }
  
  function handleLastName(e) {
    setLastName(e.target.value);
  }
  
  function handleEmail(e) {
    setEmail(e.target.value);
  }
  
  function saveOrUpdateEmployee(e) {
    e.preventDefault();
  
    // Form validation
    if (!firstname || !lastname || !email) {
      setFormError('Please fill in all fields.');
      return;
    } else {
      setFormError(null);
    }
  
    const employeeData = { firstname, lastname, email };
  
    if (id) {
      // Update employee
      updateEmployee(id, employeeData)
        .then((response) => {
          console.log(response.data);
          navigate('/employees');
        })
        .catch((error) => {
          console.error('Error updating employee:', error);
        });
    } else {
      // Create employee
      createEmployee(employeeData)
        .then((response) => {
          console.log(response.data);
          navigate('/employees');
        })
        .catch((error) => {
          console.error('Error saving employee:', error);
        });
    }
  }
  

  function pageTitle() {
    if (id) {
      return <h2 className='text-center'>Update Employee</h2>;
    } else {
      return <h2 className='text-center'>Add Employee</h2>;
    }
  }

  return (
    <div className='container'>
      <br /> <br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          {pageTitle()} {/* Render the dynamic page title */}
          <div className='card-body'> 
            <form>
              <div className='form-group mb-2'> 
                <label htmlFor='firstname' className='form-label'>First Name</label>
                <input
                  type='text'
                  id='firstname'
                  placeholder='Enter employee first name'
                  value={firstname}
                  className='form-control'
                  onChange={handleFirstName}
                  required
                />
              </div>
              <div className='form-group mb-2'> 
                <label htmlFor='lastname' className='form-label'>Last Name</label>
                <input
                  type='text'
                  id='lastname'
                  placeholder='Enter employee last name'
                  value={lastname}
                  className='form-control'
                  onChange={handleLastName}
                  required
                />
              </div>
              <div className='form-group mb-2'> 
                <label htmlFor='email' className='form-label'>Email</label>
                <input
                  type='text'
                  id='email'
                  placeholder='Enter employee email'
                  value={email}
                  className='form-control'
                  onChange={handleEmail}
                  required
                />
              </div>
              {formError && <div className='text-danger'>{formError}</div>}
              <button className='btn btn-success' onClick={saveOrUpdateEmployee}>Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
