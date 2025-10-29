// Fade-in animation for cards
document.addEventListener("DOMContentLoaded", () => {
    const cards = document.querySelectorAll(".card");
    cards.forEach(card => {
        card.style.opacity = 0;
        setTimeout(() => {
            card.style.transition = "opacity 0.6s ease-in";
            card.style.opacity = 1;
        }, 200);
    });
});

// Delete confirmation
function confirmDelete(event, name) {
    if (!confirm(`Are you sure you want to delete "${name}"?`)) {
        event.preventDefault();
    }
}
