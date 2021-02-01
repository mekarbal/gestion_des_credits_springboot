const saveClient = (e) => {
  e.preventDefault();
  const firstName = document.getElementById("firstName");
  const lastName = document.getElementById("lastName");
  const email = document.getElementById("email");
  const job = document.getElementById("job");

  clientForm = {
    fName: firstName.value,
    lName: lastName.value,
    job: job.value,
    email: email.value,
  };

  fetch("http://localhost:3333/save", {
    method: "POST",
    body: JSON.stringify(clientForm),
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  }).then((data) => console.log(data));

  firstName.value = "";
  lastName.value = "";
  email.value = "";
  job.value = "";
  console.log(clientForm);
};
