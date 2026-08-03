async function loadDrafts(){

const response = await fetch('/api/posts/drafts');
const drafts = await response.json();

//loops through drafts
drafts.forEach(draft => {
    createDraftFile(draft);
});

}

function createDraftFile(draft) {
   //creates a new div element for the draft
    const draftDiv = document.createElement('div');

    //makes file icon
    const icon = document.createElement('i');
    icon.textContent = '📄'; 

    //this makes the title
    const title = document.createElement('h3');
    title.textContent = draft.title;

    //add both divs
    draftDiv.appendChild(icon);
    draftDiv.appendChild(title);

    //adding click event
    draftDiv.addEventListener('click', function() {
        openDraft(draft);
    });
    const draftContainer = document.getElementById('draftContainer');
    draftContainer.appendChild(draftDiv);
    
}

loadDrafts();

async function openDraft(draft) {

    //this sends the user to the publisding page with the drafts conents already loaded in the editor

    window.location.href = `/adddingDoc/index.html?draftId=${draft.id}`;
}