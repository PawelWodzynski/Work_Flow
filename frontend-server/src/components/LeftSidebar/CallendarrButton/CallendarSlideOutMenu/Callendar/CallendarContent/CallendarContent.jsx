import React from "react";
import "./CallendarContent.css";

const CallendarContent = () => {
  return (
    <>
      <table className="callendar-table">
        <tr>
          <td className="bold-month-name ">Sun</td>
          <td className="bold-month-name ">Mon</td>
          <td className="bold-month-name ">Tue</td>
          <td className="bold-month-name ">Wed</td>
          <td className="bold-month-name ">Thu</td>
          <td className="bold-month-name ">Fri</td>
          <td className="bold-month-name ">Sat</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="faded-day ">26</td>
          <td className="faded-day">27</td>
          <td className="faded-day">28</td>
          <td className="faded-day"> 29</td>
          <td className="faded-day">30</td>
          <td className="faded-day">31</td>
          <td className="bold-day">1</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="bold-day">2</td>
          <td className="bold-day">3</td>
          <td className="bold-day marked-task">4</td>
          <td className="bold-day">5</td>
          <td className="bold-day">6</td>
          <td className="bold-day">7</td>
          <td className="bold-day">8</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="bold-day">9</td>
          <td className="bold-day">10</td>
          <td className="bold-day">11</td>
          <td className="bold-day">12</td>
          <td className="bold-day">13</td>
          <td className="bold-day">14</td>
          <td className="bold-day">15</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="bold-day">16</td>
          <td className="bold-day day-range-left">17</td>
          <td className="bold-day day-range-center">18</td>
          <td className="bold-day day-range-center">19</td>
          <td className="bold-day day-range-center">20</td>
          <td className="bold-day day-range-right">21</td>
          <td className="bold-day">22</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="bold-day">23</td>
          <td className="bold-day">24</td>
          <td className="bold-day">25</td>
          <td className="bold-day">26</td>
          <td className="bold-day">27</td>
          <td className="bold-day">28</td>
          <td className="bold-day">29</td>
        </tr>
        <tr className="border-bottom-tr">
          <td className="bold-day">30</td>
          <td className="bold-day">31</td>
          <td className="faded-day">1</td>
          <td className="faded-day">2</td>
          <td className="faded-day">3</td>
          <td className="faded-day">4</td>
          <td className="faded-day">5</td>
        </tr>
      </table>
    </>
  );
};

export default CallendarContent;
