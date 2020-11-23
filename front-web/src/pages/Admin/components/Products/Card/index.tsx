import React from 'react';
import './styles.scss';

const Card = () => {
  return (
    <div className="card-base product-card-admin">
    <div className="row">
      <div className="col-2 text-center border-right py-3">
        <img src="https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg"
        alt="Produto teste"
        className="product-card-image-admin"
        />
      </div>
      <div className="col-7 py-3">
        <h1 className="product-card-name-admin">
          Computador i7
        </h1>
      </div>
      <div className="col3 py-3">
        <h3>Ações</h3>
      </div>
    </div>
    </div>
  )
}

export default Card;