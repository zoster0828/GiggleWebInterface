document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:80/articles/latest')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('news-container');
            data.forEach(article => {
                const link = document.createElement('a');
                link.href = article.url;
                link.className = 'card';
                link.target = '_blank';

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

                content.appendChild(logo);
                content.appendChild(title);
                link.appendChild(imageDiv);
                link.appendChild(content);
                container.appendChild(link);
            });
        })
        .catch(error => console.error('Error loading the articles:', error));
});
