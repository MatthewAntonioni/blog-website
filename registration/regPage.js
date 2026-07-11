document.getElementById('loginForm').addEventListener('submit', async function(e) {e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/api/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });

        

        if (response.ok) {
            window.location.href = '/front-page.html';
        }
        
    } catch (error) {
        document.getElementById('error').textContent = 'An error occurred. Please try again later.';
    }

});

    


