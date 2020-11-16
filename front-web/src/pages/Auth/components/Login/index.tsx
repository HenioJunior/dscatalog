import ButtonIcon from 'core/components/Buttonicon';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import AuthCard from '../Card';
import './styles.scss';
import { makeLogin } from 'core/utils/request';

type FormData = {
  username: string;
  password: string;
}

const Login = () => {
  const { register, handleSubmit } = useForm<FormData>();
  const [hasError, setHasError] = useState(false);

  const onSubmit = (data: FormData) => {
    console.log(data);
    makeLogin(data)
    .then(response => {setHasError(false);
    })
    .catch(() => {setHasError(true);
    })
  }

  return (
    <AuthCard title="Login">
      {hasError && (
      <div className="alert alert-danger mt5">
        Usuário ou senha inválidos!
      </div>
      )}
      <form className="login-form" onSubmit={handleSubmit(onSubmit)}>
      <input 
      type="email"
      className="form-control input-base margin-bottom-30"
      placeholder="Email"
      name="username"
      ref={register({ required: true })}
      />
       <input 
      type="password"
      className="form-control input-base"
      placeholder="Senha"
      name="password"
      ref={register({ required: true , minLength: 5 })}
      />
      <Link to="/admin/auth/recover" className="login-link-recover">
      Esqueci a senha?
      </Link>
      <div className="login-submit">
      <ButtonIcon text="Logar" />
      </div>
      <div className="text-center">
        <span className="not-registered">
          Não tem Cadastro?
        </span>
        <Link to="/admin/auth/register" className="login-link-register">
        CADASTRAR
        </Link>
      </div>
      </form>
    </AuthCard>
  )

}

export default Login;