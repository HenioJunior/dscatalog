import { makeRequest } from 'core/utils/request';
import React, { useState } from 'react';
import BaseForm from '../../BaseForm';
import './styles.scss';

type FormState = {
name: string;
price: string;
category: string;
description: string;
}

type FormEvent = React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>;

const Form = () => {
  const [formData, setFormData] = useState<FormState>({
    name: '',
    price: '',
    category: '',
    description: ''
  });

  const handleOnChange = (event: FormEvent) => {
    const name = event.target.name;
    const value = event.target.value;

    setFormData(data => ({ ...data, [name]: value }));
  }
  
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const payload = {
      ...formData,
      imgUrl: 'https://i.zst.com.br/images/console-xbox-one-x-1-tb-microsoft-4k-hdr-photo186841451-12-a-15.jpg',
      categories: [{id: formData.category}]
    }

    makeRequest({url: '/products', method: 'POST', data: payload}).then(() => {
      setFormData({ name: '', category: '', price: '', description: '' });
    }); 
  }
  
  return (
    <form onSubmit={handleSubmit}>
      <BaseForm title="cadastrar um produto">
        <div className="row">
        <div className="col-6">
        <input
        value={formData.name}
        name="name"
        type="text"
        className="form-control mb-5"
        onChange={handleOnChange}
        placeholder="Nome do produto"
        />
        <select
          value={formData.category}
          className="form-control mb-5" onChange={handleOnChange}
          name="category"
          >
          <option value="3">Computadores</option>
          <option value="2">Eletrônicos</option>
          <option value="1">Livros</option>
        </select>
        <input
        value={formData.price}
        name="price"
        type="text"
        className="form-control"
        onChange={handleOnChange}
        placeholder="Preço"
        />
        </div>
        <div className="col-6">
          <textarea
          name="description"
          value={formData.description}
          className="form-control"
          onChange={handleOnChange}
          cols={30}
          rows={10}
          />
        </div>
      </div>
    </BaseForm>      
    </form>
  )
}

export default Form;