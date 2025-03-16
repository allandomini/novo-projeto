import React, { useState } from 'react';
import WeeklyPlannerApp from './components/planner/weeklyPlannerApp';
import ProductivityTools from './components/tools/ProductivityTools';
import AnalysesTab from './components/analyses/AnalysesTab';

// Componente principal que gerencia todas as abas
const ProductivityApp = () => {
  const [activeTab, setActiveTab] = useState("planner");

  return (
    <div className="flex flex-col min-h-screen bg-gray-900 text-white">
      {/* Cabeçalho */}
      <header className="bg-black p-4 shadow-md">
        <h1 className="text-2xl font-bold mb-2 text-red-600">Sistema de Produtividade</h1>
        <div className="flex space-x-2">
          <button 
            onClick={() => setActiveTab("planner")}
            className={`px-4 py-2 rounded-t-lg font-medium transition-colors ${
              activeTab === "planner" 
                ? "bg-red-800 text-white" 
                : "bg-gray-800 text-gray-300 hover:bg-gray-700"
            }`}
          >
            Planejador
          </button>
          <button 
            onClick={() => setActiveTab("tools")}
            className={`px-4 py-2 rounded-t-lg font-medium transition-colors ${
              activeTab === "tools" 
                ? "bg-red-800 text-white" 
                : "bg-gray-800 text-gray-300 hover:bg-gray-700"
            }`}
          >
            Ferramentas
          </button>
          <button 
            onClick={() => setActiveTab("analyses")}
            className={`px-4 py-2 rounded-t-lg font-medium transition-colors ${
              activeTab === "analyses" 
                ? "bg-red-800 text-white" 
                : "bg-gray-800 text-gray-300 hover:bg-gray-700"
            }`}
          >
            Análises
          </button>
        </div>
      </header>

      {/* Conteúdo principal */}
      <main className="flex-grow">
        {activeTab === "planner" && <WeeklyPlannerApp />}
        {activeTab === "tools" && <ProductivityTools />}
        {activeTab === "analyses" && <AnalysesTab />}
      </main>

      {/* Rodapé */}
      <footer className="bg-black text-gray-400 text-center p-3 text-sm">
        Sistema de Produtividade {new Date().getFullYear()}
      </footer>
    </div>
  );
};

export default ProductivityApp;
