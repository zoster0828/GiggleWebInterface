document.addEventListener('DOMContentLoaded', function() {
    const siteColors = {
        'BLIND': 'rgba(255, 99, 71, 0.2)', // 예시 사이트1의 배경색
        'OPGG': 'rgba(135, 206, 235, 0.2)', // 예시 사이트2의 배경색
        // 여기에 더 많은 사이트와 해당하는 rgba 색상 추가
    };
    fetch('http://175.207.69.232:8080/articles/latest')
        .then(response => response.json())
        .then(data => {
            const container = document.getElementById('news-container');
            data.forEach(article => {
                const link = document.createElement('a');
                link.href = article.url;
                link.className = 'card';
                link.target = '_blank';

                const bgColor = siteColors[article.site] || 'rgba(255, 255, 255, 0.5)'; // 기본 배경색 설정
                link.style.backgroundColor = bgColor;

                const imageUrl = article.thumbnailUrl || 'img/nothumb.png'; // 기본 이미지 경로를 설정하세요

                const imageDiv = document.createElement('div');
                imageDiv.className = 'card-image';
                imageDiv.style.backgroundImage = `url(${imageUrl})`;


                const content = document.createElement('div');
                content.className = 'card-content';

                const logo = document.createElement('img');
                logo.className = 'card-logo';
                logo.src = 'favicons/'+article.site+'.png'; // 로고 이미지 경로
                logo.alt = `${article.site} 로고`;

                const title = document.createElement('h4');
                title.className = 'card-title';
                title.textContent = article.title;

                const previewText = document.createElement('div');
                previewText.className = 'card-preview-text';
                previewText.textContent = article.preText; // preText 값 사용

                const stats = document.createElement('div');
                stats.className = 'card-stats';

                const views = document.createElement('span');
                views.className = 'card-views';
                views.innerHTML = `&#128065; ${article.views}`; // 조회수 이모티콘

                const likes = document.createElement('span');
                likes.className = 'card-likes';
                likes.innerHTML = `&#10084; ${article.likes}`; // 좋아요 이모티콘

                stats.appendChild(views);
                stats.appendChild(likes);

                const titleContainer = document.createElement('div');
                titleContainer.className = 'title-container';
                titleContainer.appendChild(title);
                titleContainer.appendChild(logo);

                content.appendChild(stats);
                content.appendChild(titleContainer);
//                content.appendChild(logo);
//                content.appendChild(title);
                content.appendChild(previewText);
                link.appendChild(imageDiv);
                link.appendChild(content);
                container.appendChild(link);
            });
        })
        .catch(error => console.error('Error loading the articles:', error));
});
