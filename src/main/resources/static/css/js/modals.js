const modalsData = [
    {
        id: "faqModal-1",
        title: "ДОГЛЯД ЗА ТАТУ",
        content: "Lorem150"
    },
    {
        id: "faqModal-2",
        title: "ЗАГОЕННЯ",
        content: "Lorem ipsum dolor sit amet..."
    },
    {
        id: "faqModal-3",
        title: "Питання1",
        content: "Lorem ipsum dolor sit amet..."
    },
    {
        id: "faqModal-4",
        title: "Питання2",
        content: "Lorem ipsum dolor sit amet..."
    },
    {
        id: "faqModal-5",
        title: "Питання3",
        content: "Lorem ipsum dolor sit amet..."
    },
    {
        id: "faqModal-6",
        title: "Питання4",
        content: "Lorem ipsum dolor sit amet..."
    },
];

for (const modalData of modalsData) {
    document.write(`<div class="modal fade" id="${modalData.id}" tabindex="-1" role="dialog" aria-labelledby="${modalData.id}" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <h5 class="model-title text-center" id="${modalData.id}Label">${modalData.title}</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="row text-center">
                            <p>${modalData.content}</p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="button btn btn-secondary" data-dismiss="modal">Close</div>
                </div>
            </div>
        </div>
    </div>`);
}
