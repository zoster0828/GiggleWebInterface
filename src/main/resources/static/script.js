document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/articles/latest')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('news-container');
            data.forEach(article => {
                const card = document.createElement('div');
                card.className = 'card';

                const imageDiv = document.createElement('div');
                imageDiv.className = 'card-image';
                imageDiv.style.backgroundImage = `url(${article.thumbnailUrl})`;

                const content = document.createElement('div');
                content.className = 'card-content';

                const logo = document.createElement('img');
                logo.className = 'card-logo';
                logo.src = 'favicons/'+article.site+'.png'; // 로고 이미지 경로
                logo.alt = `${article.site} 로고`;

                const title = document.createElement('h4');
                title.className = 'card-title';
                title.textContent = article.title;

                const link = document.createElement('a');
                link.className = 'card-link';
                link.href = article.url;
                link.textContent = '자세히 보기';
                link.target = '_blank';

                content.appendChild(logo);
                content.appendChild(title);
                content.appendChild(link);
                card.appendChild(imageDiv);
                card.appendChild(content);
                container.appendChild(card);
            });
        })
        .catch(error => console.error('Error loading the articles:', error));
});