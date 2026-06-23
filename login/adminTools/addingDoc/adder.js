let editor

ClassicEditor.ClassicEditor.create(document.querySelector('#editor')) 

.then(newEditor => {editor = e; })
.catch(error => console.error(error));

document.getElementById('submit').addEventListener('click', async function() {

    const title = document.getElementById('title').value;
    const content = editor.getData();

    try{

        const response = await fetch('/api/posts/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ title, content })
        });
        //add seperate functionality for drafts
        if (response.ok) {
            document.getElementById('success').textContent = 'post published';
        } else {
            document.getElementById('error').textContent = 'Failed to publish post';
        }
    }
    catch (error) {
        document.getElementById('error').textContent = 'An error occurred. Please try again later.';
    }
});