# 🧸 ToyStore - Docker Compose
## 📋 Checkpoint 1 - 2º Semestre: DevOps Tools & Cloud Computing
Migração de aplicação monolítica para arquitetura containerizada com **Docker Compose**.

---

## 👨‍💻 Desenvolvedores

| Nome                          | RM      | GitHub |
|-------------------------------|---------|--------|
| Enzo Dias Alfaia Mendes       | 558438  | [@enzodam](https://github.com/enzodam) |
| Matheus Henrique Germano Reis | 555861  | [@MatheusReis48](https://github.com/MatheusReis48) |
| Luan Dantas dos Santos        | 559004  | [@lds2125](https://github.com/lds2125) |

---

## 🏗️ Arquitetura

### 🔴 Arquitetura Antiga (Monolítica)
```
[Usuário] → [Aplicação + PostgreSQL no mesmo servidor]
```

### 🟢 Arquitetura Nova (Containerizada)
```
[Usuário] → [Container: toystore-app:8080] ←→ [Container: toystore-db:5432]
```

---

## ⚙️ Serviços Docker Compose

### 1. **toystore-app**
- Imagem: Spring Boot (build customizado)
- Porta: `8080:8080`
- Depende de: **toystore-db**

### 2. **toystore-db**
- Imagem: `postgres:15` (oficial)
- Porta: `5432:5432`
- Volume: `postgres_data` (persistência de dados)

---

## 🚀 Como Executar - PASSO A PASSO

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/seu-usuario/Cp4-ToyStore.git
cd Cp4-ToyStore
```

### 2️⃣ Configure o ambiente (OBRIGATÓRIO)
```bash
# Copie o arquivo de exemplo
cp .env.example .env
```

➡️ Agora edite o arquivo `.env` e substitua `sua_senha_aqui` pela senha que deseja para o PostgreSQL.  
Exemplo:
```env
DB_PASSWORD=minha_senha_super_secreta_123
```

### 3️⃣ Execute a aplicação com Docker Compose
```bash
docker-compose up -d --build
```

### 4️⃣ Verifique se tudo está funcionando
```bash
docker-compose ps
docker-compose logs app
```

---

## 🧪 Testes - Verifique se está tudo OK

### 🔹 Testar o Banco PostgreSQL
```bash
# Listar tabelas
docker exec -it toystore-db psql -U postgres -d toystore -c "\dt"

# Consultar brinquedos
docker exec -it toystore-db psql -U postgres -d toystore -c "SELECT * FROM brinquedo;"
```

### 🔹 Testar a API Spring Boot
```bash
# Endpoint da API
curl http://localhost:8080/loja-de-brinquedos/api/brinquedos
```

---

## 📋 Comandos Úteis

```bash
# Parar todos os serviços
docker-compose down

# Parar e remover volumes (⚠️ apaga dados do banco)
docker-compose down -v

# Ver logs em tempo real
docker-compose logs -f app

# Ver status dos containers
docker-compose ps

# Rebuildar a aplicação
docker-compose up -d --build
```

---

## ⚠️ Troubleshooting - Solução de Problemas

🔴 **Porta 8080 ou 5432 já está em uso?**
```bash
# Encerre o processo que usa a porta ou altere as portas no docker-compose.yml
```

🔴 **Erro de conexão com o banco?**
```bash
# Verifique o arquivo .env
# Confirme se a senha no .env é a mesma no docker-compose.yml
```

🔴 **Build falha?**
```bash
docker-compose build --no-cache
```

🔴 **Container não sobe?**
```bash
docker-compose logs
```

---

## 🎯 Acesso à Aplicação

- **API Spring Boot** → [http://localhost:8080](http://localhost:8080)
- **Banco PostgreSQL** → `localhost:5432`
   - Usuário: `postgres`
   - Senha: definida no `.env`
   - Banco: `toystore`

---

## 📎 Links

- 📂 GitHub: [https://github.com/enzodam/Cp4-ToyStore]
- 🎥 Vídeo Demo: [link-do-video-demo]
- 📚 [Documentação Docker](https://docs.docker.com/)  
