
USE `proyectos`;

INSERT INTO users (user_id,password) VALUES 
     ('Liskova','5sPaWyBmNNfz81htdH/9s2tcZ1dXs4DGpf5cVwxxQ0k='), 
     ('Ullmanova','G6PRbpiBlZ+MmpdihU9yxuYyHN1ENYoQpOk5AzEX6rk='),
     ('Turinova', 'OstZMG725mDPgy0dNMT7o9iNYW8LtcKp4PgtGO9vwWc='),
     ('Newmanova', 'pBe13D0G0V2Rxmh+J/wXBevFazstgTq+AwZuVkP+TnQ=');

INSERT INTO roles (user_id,role) VALUES 
     ('Liskova','jefe_protecto'),
     ('Ullmanova','programador'),
     ('Turinova','programador'),
     ('Newmanova','programador'); 

