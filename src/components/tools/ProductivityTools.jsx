import React from 'react';
import PomodoroTimer from './PomodoroTimer';
import GoalsList from './GoalsList';
import FinancialDashboard from './FinancialDashboard';
import FinanceCalculator from './FinanceCalculator';
import PatrimonialGoals from './PatrimonialGoals';

// Componente para as ferramentas de produtividade
const ProductivityTools = () => {
  return (
    <div className="p-4 md:p-6 bg-gray-900">
      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6 max-w-6xl mx-auto">
        <div className="lg:col-span-1">
          <PomodoroTimer />
          <div className="mt-6">
            <GoalsList />
          </div>
        </div>
        <div className="lg:col-span-2">
          <FinancialDashboard />
          <div className="mt-6">
            <FinanceCalculator />
          </div>
          <div className="mt-6">
            <PatrimonialGoals />
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductivityTools;