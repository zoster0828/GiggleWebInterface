fetch('http://localhost:8080/articles/latest')
    .then(response => response.json())
    .then(data => {
        const cardRow = document.getElementById('card-row');
        data.forEach(article => {
            const cardLink = document.createElement('a');
            cardLink.href = article.url; // 기사 URL 설정
            cardLink.classList.add('card-link'); // 스타일링을 위한 클래스 추가

            const card = document.createElement('div');
            card.classList.add('col-md-4');

            card.innerHTML = `
                <div class="card">
                    <img src="${article.thumbnailUrl}" class="card-img-top" alt="Thumbnail">
                    <div class="card-body">
                        <h5 class="card-title"><img src="../favicons/${article.site}.png" alt="Logo">${article.title}</h5>
                        <p class="card-text">${article.preText}</p>
                    </div>
                </div>
            `;

            cardLink.appendChild(card); // 카드를 <a> 태그 내부에 추가
            cardRow.appendChild(cardLink); // 링크를 행에 추가
        });
    })
    .catch(error => console.error('Error fetching data:', error));
