let editor

ClassicEditor.create(document.querySelector('#editor'))

.then(newEditor => {editor = e; })
.catch(error => console.error(error));

document.getElementById('submit').addEventListener('click', async function() {

    const title = document.getElementById('title').value;
    const content = editor.getData();

    //this strips the html tags from the content so that it can later be sorter for the preview
    const plainText = content.replace(/<[^>]*>/g, '');

    //this will split the text into 3 different sentences
    const sentences = plainText.match(/[^.!?]+[.!?]+/g);
    const preview = sentences ? sentences.slice(0, 3).join(' ') : plainText.substring(0, 100);

    try{

        const response = await fetch('/api/posts/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ title, content, preview })
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