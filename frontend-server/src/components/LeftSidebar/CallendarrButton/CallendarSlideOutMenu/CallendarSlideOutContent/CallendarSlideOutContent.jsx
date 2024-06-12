import React from "react";
import "./CallendarSlideOutContent.css";
import ContentCallendarList from "./ContentCallendarList/ContentCallendarList";

const CallendarSlideOutContent = ({ isAddMenuVisible }) => {
  return (
    <div className="slide-out-callendar-menu-body">
      <ContentCallendarList
        isAddMenuVisible={isAddMenuVisible}
      ></ContentCallendarList>
    </div>
  );
};

export default CallendarSlideOutContent;
