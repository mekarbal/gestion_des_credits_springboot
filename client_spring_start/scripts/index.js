const saveClient = (e) => {
  e.preventDefault();
  const firstName = document.getElementById("firstName");
  const lastName = document.getElementById("lastName");
  const email = document.getElementById("email");
  const job = document.getElementById("job");
  const taux = document.getElementById("credits");
  const amount = document.getElementById("amount");

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
  })
    .then((data) => console.log(data))
    .then(async () => {
      await calculateInt(amount.value, taux.value);
    });

  firstName.value = "";
  lastName.value = "";
  email.value = "";
  job.value = "";

  console.log(clientForm);
};

const getAllCredits = async () => {
  var html;
  await fetch("http://localhost:3333/credits", {
    method: "GET",
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  })
    .then((rs) => rs.json())
    .then((data) => {
      data.map((credit) => {
        html = `<option value=${credit.taux}>${credit.name}</option>`;
        document.getElementById("credits").innerHTML += html;
      });
    });
};

const calculateInt = async (amount, taux) => {
  await fetch(
    `http://localhost:3333/calculCreditamount=${amount}&taux=${taux}`,
    {
      method: "GET",
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    }
  )
    .then((res) => res.json())
    .then((json) => {
      console.log(json);
    });
};
getAllCredits();
