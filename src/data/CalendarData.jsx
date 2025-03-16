// Arquivo: src/data/CalendarData.jsx
import React from 'react';

// Função para formatar data no formato YYYY-MM-DD
export function formatDate(date) {
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');
  return `${year}-${month}-${day}`;
}

// Função para obter o dia atual da semana
export function obterDiaAtual() {
  const dias = ["Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"];
  const hoje = new Date().getDay();
  return dias[hoje];
}

// Função para obter datas da semana atual (de domingo a sábado)
export function getDatasSemanais() {
  const hoje = new Date();
  const diaSemana = hoje.getDay(); // 0 = Domingo, 1 = Segunda, etc.
  
  // Encontrar o domingo desta semana (início da semana)
  const inicioSemana = new Date(hoje);
  inicioSemana.setDate(hoje.getDate() - diaSemana);
  
  // Criar array com as 7 datas da semana
  const datasSemanais = [];
  for (let i = 0; i < 7; i++) {
    const dia = new Date(inicioSemana);
    dia.setDate(inicioSemana.getDate() + i);
    datasSemanais.push(formatDate(dia));
  }
  
  return datasSemanais;
}

// Banco de dados do calendário
// Chave: data no formato YYYY-MM-DD, Valor: objeto com projeto e tarefas
export const calendarDatabase = {
  // Semana de exemplo (16-22 de março de 2025)
  "2025-03-16": {
    projeto: "Planejamento Semanal",
    tarefas: [
      { text: "Revisar objetivos da semana anterior", completed: false },
      { text: "Definir metas para a próxima semana", completed: false },
      { text: "Organizar calendário e tarefas", completed: false }
    ]
  },
  "2025-03-17": {
    projeto: "Curso de IA para Jogos (Creative Coursera)",
    tarefas: [
      { text: "Trabalhar no curso de IA para jogos: planejar ou gravar aulas em inglês", completed: false },
      { text: "Produzir vídeos relacionados (gravar, editar ou planejar)", completed: false },
      { text: "Criar conteúdos gratuitos para testar o tema (ex.: vídeo curto para YouTube)", completed: false },
      { text: "Manter o canal ativo: responder comentários e interagir com a audiência", completed: false }
    ]
  },
  "2025-03-18": {
    projeto: "Vender Sites",
    tarefas: [
      { text: "Aprender a criar sites (usar tutoriais de WordPress, HTML ou ferramentas no-code)", completed: false },
      { text: "Desenvolver habilidades de vendas (estudar técnicas, criar script de abordagem)", completed: false },
      { text: "Trabalhar em um portfólio de sites (fazer projetos de demonstração)", completed: false },
      { text: "Prospectar clientes (pesquisar contatos, enviar e-mails ou mensagens)", completed: false }
    ]
  },
  "2025-03-19": {
    projeto: "Modelos 3D",
    tarefas: [
      { text: "Desenvolver habilidades de modelagem 3D", completed: false },
      { text: "Criar novos assets para venda", completed: false },
      { text: "Atualizar portfólio online", completed: false }
    ]
  },
  "2025-03-20": {
    projeto: "Jogo STEAM",
    tarefas: [
      { text: "Trabalhar na programação do protótipo", completed: false },
      { text: "Desenvolver assets gráficos", completed: false },
      { text: "Testar mecânicas de gameplay", completed: false }
    ]
  },
  "2025-03-21": {
    projeto: "Captação de clientes",
    tarefas: [
      { text: "Enviar propostas para potenciais clientes", completed: false },
      { text: "Fazer follow-up de contatos anteriores", completed: false },
      { text: "Atualizar materiais de marketing", completed: false }
    ]
  },
  "2025-03-22": {
    projeto: "Aprendizado",
    tarefas: [
      { text: "Estudar novas tecnologias", completed: false },
      { text: "Assistir tutoriais relevantes", completed: false },
      { text: "Praticar novas habilidades", completed: false }
    ]
  },
  
  // Próxima semana
  "2025-03-23": {
    projeto: "Revisão Semanal",
    tarefas: [
      { text: "Revisar progresso da semana", completed: false },
      { text: "Planejar a próxima semana", completed: false }
    ]
  },
  "2025-03-24": {
    projeto: "Finalização do Curso IA",
    tarefas: [
      { text: "Gravar últimos vídeos do curso", completed: false },
      { text: "Fazer edição final", completed: false },
      { text: "Preparar lançamento", completed: false }
    ]
  }
};

// Função para obter o planejamento da semana atual
export function getPlanejamentoSemanal() {
  const datas = getDatasSemanais();
  const planejamento = {};
  
  // Dias da semana em português
  const diasSemana = ["Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"];
  
  // Para cada dia da semana, buscar os dados correspondentes
  for (let i = 0; i < 7; i++) {
    const data = datas[i];
    const diaSemana = diasSemana[i];
    
    // Se existirem dados para esta data, use-os
    if (calendarDatabase[data]) {
      planejamento[diaSemana] = calendarDatabase[data];
    } else {
      // Caso contrário, crie um projeto vazio
      planejamento[diaSemana] = {
        projeto: "Sem projeto definido",
        tarefas: []
      };
    }
  }
  
  return planejamento;
}

// Função para salvar ou atualizar dados no calendário
export function saveToCalendar(date, data) {
  calendarDatabase[date] = data;
  
  // Na implementação real, você salvaria no localStorage aqui:
  // localStorage.setItem('calendarDatabase', JSON.stringify(calendarDatabase));
  
  return calendarDatabase;
}

// Função para obter dados de uma data específica
export function getCalendarDataForDate(date) {
  return calendarDatabase[date] || null;
}

// Função para obter o dia da semana a partir de uma data
export function getDiaSemana(date) {
  const dias = ["Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"];
  const data = new Date(date);
  return dias[data.getDay()];
}

// Função para obter datas da próxima semana
export function getDatasProximaSemana() {
  const hoje = new Date();
  const diaSemana = hoje.getDay();
  
  // Encontrar o domingo da próxima semana
  const inicioProximaSemana = new Date(hoje);
  inicioProximaSemana.setDate(hoje.getDate() - diaSemana + 7); // +7 para ir para próxima semana
  
  // Criar array com as 7 datas da próxima semana
  const datasProximaSemana = [];
  for (let i = 0; i < 7; i++) {
    const dia = new Date(inicioProximaSemana);
    dia.setDate(inicioProximaSemana.getDate() + i);
    datasProximaSemana.push(formatDate(dia));
  }
  
  return datasProximaSemana;
}

// Função para buscar os dados do período desejado (semana atual, próxima, etc.)
export function getPlanejamentoPorPeriodo(periodo = 'atual') {
  let datas;
  
  if (periodo === 'atual') {
    datas = getDatasSemanais();
  } else if (periodo === 'proxima') {
    datas = getDatasProximaSemana();
  } else {
    // Caso queira implementar outros períodos no futuro
    datas = getDatasSemanais();
  }
  
  const planejamento = {};
  const diasSemana = ["Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"];
  
  for (let i = 0; i < 7; i++) {
    const data = datas[i];
    const diaSemana = diasSemana[i];
    
    if (calendarDatabase[data]) {
      planejamento[diaSemana] = calendarDatabase[data];
    } else {
      planejamento[diaSemana] = {
        projeto: "Sem projeto definido",
        tarefas: []
      };
    }
  }
  
  return planejamento;
}

// Função utilitária para atualizar tarefas em um dia específico
export function updateTaskStatus(data, diaSemana, indexTarefa, completed) {
  if (calendarDatabase[data] && 
      calendarDatabase[data].tarefas && 
      calendarDatabase[data].tarefas[indexTarefa] !== undefined) {
    
    calendarDatabase[data].tarefas[indexTarefa].completed = completed;
    
    // Na implementação real, você salvaria no localStorage aqui:
    // localStorage.setItem('calendarDatabase', JSON.stringify(calendarDatabase));
    
    return true;
  }
  
  return false;
}

// Função para obter o primeiro dia do mês
export function getFirstDayOfMonth(year, month) {
  return new Date(year, month, 1);
}

// Função para obter o último dia do mês
export function getLastDayOfMonth(year, month) {
  return new Date(year, month + 1, 0);
}

// Função para gerar dias do calendário para um mês específico
export function generateCalendarDays(year, month) {
  const firstDay = getFirstDayOfMonth(year, month);
  const lastDay = getLastDayOfMonth(year, month);
  const days = [];
  
  // Adicionar dias do mês anterior para preencher a primeira semana
  const firstDayOfWeek = firstDay.getDay();
  for (let i = firstDayOfWeek - 1; i >= 0; i--) {
    const prevDate = new Date(year, month, -i);
    const dateStr = formatDate(prevDate);
    days.push({
      date: prevDate,
      dateStr: dateStr,
      isCurrentMonth: false,
      hasTasks: !!calendarDatabase[dateStr]
    });
  }
  
  // Adicionar dias do mês atual
  for (let i = 1; i <= lastDay.getDate(); i++) {
    const date = new Date(year, month, i);
    const dateStr = formatDate(date);
    days.push({
      date: date,
      dateStr: dateStr,
      isCurrentMonth: true,
      hasTasks: !!calendarDatabase[dateStr]
    });
  }
  
  // Adicionar dias do próximo mês para preencher a última semana
  const lastDayOfWeek = lastDay.getDay();
  for (let i = 1; i < 7 - lastDayOfWeek; i++) {
    const nextDate = new Date(year, month + 1, i);
    const dateStr = formatDate(nextDate);
    days.push({
      date: nextDate,
      dateStr: dateStr,
      isCurrentMonth: false,
      hasTasks: !!calendarDatabase[dateStr]
    });
  }
  
  return days;
}

// Dados de referência
export const weekdayNames = ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'];
export const monthNames = [
  'Janeiro', 'Fevereiro', 'Março', 'Abril', 
  'Maio', 'Junho', 'Julho', 'Agosto', 
  'Setembro', 'Outubro', 'Novembro', 'Dezembro'
];
