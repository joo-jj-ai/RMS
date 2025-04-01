const apiUrl = 'http://localhost:8080/ration'; 

// Register User
document.getElementById('registerForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const user = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        mobileNumber: document.getElementById('mobileNumber').value,
        rationCardNumber: document.getElementById('rationCardNumber').value,
        status: "ACTIVE",
    };

    try {
        const response = await fetch(`${apiUrl}/users/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user),
        });

        const data = await response.json();
        alert('User Registered Successfully');
    } catch (error) {
        console.error('Error registering user', error);
    }
});

// Get User by Ration Card Number
document.getElementById('getUserForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const rationCardNumber = document.getElementById('searchRationCardNumber').value;

    try {
        const response = await fetch(`${apiUrl}/users/${rationCardNumber}`);
        const user = await response.json();

        document.getElementById('userDetails').innerHTML = `
            <h3>User Details:</h3>
            <p>Name: ${user.name}</p>
            <p>Email: ${user.email}</p>
            <p>Mobile Number: ${user.mobileNumber}</p>
            <p>Ration Card Number: ${user.rationCardNumber}</p>
            <p>Status: ${user.status}</p>
        `;
    } catch (error) {
        document.getElementById('userDetails').innerHTML = 'User not found';
    }
});

// Deactivate User
document.getElementById('deactivateForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const userId = document.getElementById('deactivateUserId').value;

    try {
        await fetch(`${apiUrl}/users/deactivate/${userId}`, {
            method: 'PUT',
        });
        alert('User Deactivated Successfully');
    } catch (error) {
        alert('Error deactivating user');
    }
});

// Add Stock
document.getElementById('addStockForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const stock = {
        itemName: document.getElementById('itemName').value,
        availableQuantity: document.getElementById('availableQuantity').value,
        pricePerUnit: document.getElementById('pricePerUnit').value,
    };

    try {
        await fetch(`${apiUrl}/stocks/add`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(stock),
        });
        alert('Stock Added Successfully');
    } catch (error) {
        alert('Error adding stock');
    }
});

// Get Stock by Item Name
document.getElementById('getStockForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const itemName = document.getElementById('searchItemName').value;

    try {
        const response = await fetch(`${apiUrl}/stocks/${itemName}`);
        const stock = await response.json();

        document.getElementById('stockDetails').innerHTML = `
            <h3>Stock Details:</h3>
            <p>Item Name: ${stock.itemName}</p>
            <p>Available Quantity: ${stock.availableQuantity}</p>
            <p>Price Per Unit: ${stock.pricePerUnit}</p>
        `;
    } catch (error) {
        document.getElementById('stockDetails').innerHTML = 'Stock not found';
    }
});

// View All Stocks functionality
document.getElementById('viewAllStocksButton').addEventListener('click', async () => {
    try {
        const response = await fetch(`${apiUrl}/stocks/all`);
        const stocks = await response.json();

        if (response.ok) {
            const stockList = stocks.map(stock => `
                <div class="card">
                    <h3>${stock.itemName}</h3>
                    <p><strong>Available Quantity:</strong> ${stock.availableQuantity}</p>
                    <p><strong>Price Per Unit:</strong> ${stock.pricePerUnit}</p>
                </div>
            `).join('');

            document.getElementById('allStocksList').innerHTML = stockList;
        } else {
            document.getElementById('allStocksList').innerHTML = 'No stocks available';
        }
    } catch (error) {
        console.error('Error fetching all stocks:', error);
        document.getElementById('allStocksList').innerHTML = 'Error fetching stocks';
    }
});

// Create Ration Request
document.getElementById('createRequestForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const rationRequest = {
        user: { rationCardNumber: document.getElementById('userRationCardNumber').value },
        requestedQuantity: document.getElementById('requestQuantity').value,
        stock: { itemName: document.getElementById('stockItemName').value },
    };

    try {
        await fetch(`${apiUrl}/requests/create`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(rationRequest),
        });
        alert('Ration Request Created');
    } catch (error) {
        alert('Error creating ration request');
    }
});

// Approve/Reject Ration Request
document.getElementById('approveRejectRequestForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const requestId = document.getElementById('requestId').value;
    const comment = document.getElementById('comment').value;

    try {
        const response = await fetch(`${apiUrl}/requests/approve/${requestId}?comment=${comment}`, {
            method: 'PUT',
        });

        if (response.ok) {
            alert('Request Approved');
        } else {
            await fetch(`${apiUrl}/requests/reject/${requestId}?comment=${comment}`, {
                method: 'PUT',
            });
            alert('Request Rejected');
        }
    } catch (error) {
        alert('Error approving/rejecting request');
    }
});

// Create Grievance
document.getElementById('createGrievanceForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const grievance = {
        user: { rationCardNumber: document.getElementById('userRationCard').value },
        description: document.getElementById('description').value,
    };

    try {
        await fetch(`${apiUrl}/grievances/create`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(grievance),
        });
        alert('Grievance Created');
    } catch (error) {
        alert('Error creating grievance');
    }
});

// Resolve Grievance
document.getElementById('resolveGrievanceForm').addEventListener('submit', async (e) => {
    e.preventDefault();

    const grievanceId = document.getElementById('grievanceId').value;
    const response = document.getElementById('grievanceResponse').value;

    try {
        await fetch(`${apiUrl}/grievances/resolve/${grievanceId}?response=${response}`, {
            method: 'PUT',
        });
        alert('Grievance Resolved');
    } catch (error) {
        alert('Error resolving grievance');
    }
});


const API_URL = "http://localhost:8080/ration/policies"; 
// DOM Elements
const addPolicyForm = document.getElementById('add-policy-form');
const policyCardsContainer = document.getElementById('policy-cards');

// Function to create a policy card
function createPolicyCard(policy) {
    const card = document.createElement('div');
    card.classList.add('card');
    card.id = `policy-card-${policy.id}`;

    card.innerHTML = `
        <h3>${policy.title}</h3>
        <p><strong>Description:</strong> ${policy.description}</p>
        <p><strong>Status:</strong> ${policy.status}</p>
        <p><strong>Effective Date:</strong> ${policy.effectiveDate}</p>
        <button onclick="deletePolicy(${policy.id})">Delete</button>
        <button onclick="editPolicy(${policy.id})">Update</button>
    `;

    policyCardsContainer.appendChild(card);
}

// Function to fetch and display all policies
async function loadPolicies() {
    try {
        const response = await fetch(API_URL);
        const policies = await response.json();
        policies.forEach(createPolicyCard);
    } catch (error) {
        console.error('Error fetching policies:', error);
    }
}

// Handle form submission for adding a new policy
addPolicyForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const policy = {
        title: document.getElementById('title').value,
        description: document.getElementById('description').value,
        effectiveDate: document.getElementById('effectiveDate').value,
        status: document.getElementById('status').value,
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(policy),
        });

        const newPolicy = await response.json();
        createPolicyCard(newPolicy); 
    } catch (error) {
        alert('Error adding policy: ' + error.message);
    }

    addPolicyForm.reset(); 
});

// Function to delete a policy
async function deletePolicy(policyId) {
    try {
        await fetch(`${API_URL}/${policyId}`, {
            method: 'DELETE',
        });

        // Remove the policy card from the UI
        const policyCard = document.getElementById(`policy-card-${policyId}`);
        policyCard.remove();
    } catch (error) {
        alert('Error deleting policy: ' + error.message);
    }
}

// Function to edit a policy (you can improve this by providing a form modal)
async function editPolicy(policyId) {
    const updatedPolicy = {
        title: prompt("Enter new title:"),
        description: prompt("Enter new description:"),
        effectiveDate: prompt("Enter new effective date:"),
        status: prompt("Enter new status (ACTIVE, INACTIVE, UPDATED):")
    };

    try {
        const response = await fetch(`${API_URL}/${policyId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(updatedPolicy),
        });

        const updatedPolicyData = await response.json();

        // Update the card display
        const policyCard = document.getElementById(`policy-card-${policyId}`);
        policyCard.querySelector('h3').innerText = updatedPolicyData.title;
        policyCard.querySelector('p').innerText = `Description: ${updatedPolicyData.description}`;
    } catch (error) {
        alert('Error updating policy: ' + error.message);
    }
}

// Load all policies on page load
window.onload = loadPolicies;
