import { useState, useEffect } from 'react';

function ListaGastos() {
  const [gastos, setGastos] = useState([]);
  const [carregando, setCarregando] = useState(true);
  const [erro, setErro] = useState(null);

  useEffect(() => {
    fetch('http://localhost:8080/gastos')
      .then((resposta) => {
        if (!resposta.ok) {
          throw new Error('Erro ao buscar gastos');
        }
        return resposta.json();
      })
      .then((dados) => {
        setGastos(dados);
        setCarregando(false);
      })
      .catch((erro) => {
        setErro(erro.message);
        setCarregando(false);
      });
  }, []);

  if (carregando) return <p>Carregando gastos...</p>;
  if (erro) return <p>Erro: {erro}</p>;

  return (
    <div>
      <h2>Meus Gastos</h2>
      <ul>
        {gastos.map((gasto) => (
          <li key={gasto.id}>
            {gasto.descricao} - R$ {gasto.valor.toFixed(2)} - {gasto.data}
            {gasto.categoria && ` (${gasto.categoria.nome})`}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListaGastos;