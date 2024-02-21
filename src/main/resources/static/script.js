document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/articles/latest?count=10')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('news-container');
            data.forEach(article => {
                const card = document.createElement('div');
                card.className = 'card';

                const image = document.createElement('img');
                image.src = article.thumbnailUrl;

                const content = document.createElement('div');
                content.className = 'card-content';

                const title = document.createElement('h4');
                title.className = 'card-title';
                title.textContent = article.title;

                const link = document.createElement('a');
                link.className = 'card-link';
                link.href = article.url;
                link.textContent = '자세히 보기';
                link.target = '_blank';

                content.appendChild(title);
                content.appendChild(link);
                card.appendChild(image);
                card.appendChild(content);
                container.appendChild(card);
            });
        })
        .catch(error => console.error('Error loading the articles:', error));
});
